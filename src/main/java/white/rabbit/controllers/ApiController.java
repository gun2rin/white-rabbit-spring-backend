/*
 * Copyright (c) 2019
 *  This file is part of the White Rabbit application.
 *
 *  (c) Vladimir Ganturin <gun2rin@gmail.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package white.rabbit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import white.rabbit.config.YAMLConfig;
import white.rabbit.exeptions.FileTransformException;
import white.rabbit.models.RabbitResponse;
import white.rabbit.models.Options;
import white.rabbit.services.FileTransform;

import javax.servlet.http.HttpServletResponse;


/**
 * The type Api controller.
 */
@CrossOrigin(methods = RequestMethod.POST, allowCredentials = "true")
@RestController
public class ApiController {

    @Autowired
    private FileTransform transformer;

    @Autowired
    private YAMLConfig config;

    /**
     * Transform
     *
     * @param background      the background
     * @param foreground      the foreground
     * @param file            the file
     * @param servletResponse the servlet response
     * @return RabbitResponse rabbit response
     */
    @RequestMapping(path = "/api/transform/", method = RequestMethod.POST, produces = {
            "application/JSON"
    })

    public RabbitResponse transform(
            @RequestParam(defaultValue = "#000000") String background,
            @RequestParam(defaultValue = "#5ae200") String foreground,
            @RequestParam MultipartFile file,
            HttpServletResponse servletResponse
    ) {

        Options options = new Options(background, foreground);

        try {

            this.transformer.transform(file, options);

        } catch (FileTransformException e) {
            e.printStackTrace();
            servletResponse.setStatus(400);

        } catch (Exception e) {
            e.printStackTrace();
            servletResponse.setStatus(409);
        }


        return this.getResponse(options);
    }


    private RabbitResponse getResponse(Options options) {

        RabbitResponse response = new RabbitResponse();
        response.setMsg(this.transformer.getMessages());
        response.setFileSize(String.format("%.2f", this.transformer.getFileSize()) + " MB");
        response.setSuccess(!this.transformer.getError());

        /*
         * FileTransformer has defined filenames after saving
         */
        response.setThumb(config.getDownloadDir() + options.getThumbFileName());
        response.setFullImage(config.getDownloadLink() + options.getImageFileName());

        return response;
    }
}
