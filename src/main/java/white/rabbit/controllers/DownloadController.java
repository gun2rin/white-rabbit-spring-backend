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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import white.rabbit.config.YAMLConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * The type Download controller.
 */
@Controller
public class DownloadController {


    @Autowired
    private YAMLConfig config;

    /**
     * Download.
     *
     * @param fileName the file name
     * @param response the response
     */
    @RequestMapping(path = "/download/{fileName:.+}", method = RequestMethod.GET)

    public void download(
            @PathVariable("fileName") String fileName,
            HttpServletResponse response

    ) {

        String dataDirectory = config.getWorkDir();
        Path file = Paths.get(dataDirectory, fileName);

        if (Files.exists(file)) {
            response.setContentType("application/octet-stream");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException ex) {

                this.redirect(response);
            }
        } else {

           this.redirect(response);

        }
    }

    private void redirect(HttpServletResponse response)
    {

        response.setHeader("Location", config.getRedirectUrl());
        response.setStatus(302);

    }
}
