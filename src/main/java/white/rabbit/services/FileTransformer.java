/*
 * Copyright (c) 2019
 *  This file is part of the White Rabbit application.
 *
 *  (c) Vladimir Ganturin <gun2rin@gmail.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package white.rabbit.services;

import com.github.erihoss.img2a.AsciiImageRenderer;
import com.github.erihoss.img2a.ImageAsciiReader;
import com.github.erihoss.img2a.InvalidImageDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import white.rabbit.config.YAMLConfig;
import white.rabbit.exceptions.FileTransformException;
import white.rabbit.models.Options;

import javax.imageio.ImageIO;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The type File transformer.
 */
@Service
public class FileTransformer implements FileTransform<MultipartFile, Options> {


    private Options options;
    private MultipartFile source;
    private List<String> messages;
    private Boolean error;
    private double fileSize;


    @Autowired
    private YAMLConfig config;

    /**
     * Entry point for image transforming into ascii art
     *
     * @throws FileTransformException
     */
    @Override
    public void transform(MultipartFile source, Options options) throws FileTransformException {

        this.error = false;

        this.options = options;

        this.messages = new ArrayList<>();

        this.source = source;

        this.fileSize = source.getSize();

        if (source.isEmpty()) {
            this.error = true;
            this.messages.add(config.getMsgFail());
            throw new FileTransformException();
        }

        this.validate();
        this.render();
    }


    /**
     * Validates colors params and file type
     *
     * @return Boolean
     * @throws FileTransformException
     */
    @Override
    public Boolean validate() throws FileTransformException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Options>> violations = validator.validate(this.options);

        List<String> mimeTypeConfig = config.getMimeTypes();

        if (!violations.isEmpty()) {
            this.error = true;
            this.messages.add(config.getMsgFailColor());
            throw new FileTransformException();
        }


        if (!mimeTypeConfig.contains(this.source.getContentType())) {
            this.error = true;
            this.messages.add(config.getMsgFailType());
            throw new FileTransformException();
        }

        return this.error;
    }


    /**
     * Renders ascii image and its thumbnail from  stream
     *
     * @throws FileTransformException
     */
    private void render() throws FileTransformException {

        InputStream stream = null;

        try {

            stream = this.source.getInputStream();

            ImageAsciiReader reader = new ImageAsciiReader(ImageIO.createImageInputStream(stream));

            AsciiImageRenderer renderer = new AsciiImageRenderer(reader);

            renderer.setBackground(Color.decode(this.options.getBackground()));
            renderer.setForeground(Color.decode(this.options.getForeground()));


            int height = reader.calcAspectCorrectHeight(config.getResultWidth());


            BufferedImage img = renderer.render(new Point(config.getResultWidth(), height));
            BufferedImage thumb = new BufferedImage(config.getThumbWidth(), config.getThumbHeight(), BufferedImage.TYPE_INT_RGB);

            Graphics graphics = thumb.createGraphics();
            graphics.drawImage(img, 0, 0, config.getThumbWidth(), config.getThumbHeight(), null);
            graphics.dispose();


            String thumbFileName = this.save(thumb);
            String imageFileName = this.save(img);

            this.options.setThumbFileName(thumbFileName);
            this.options.setImageFileName(imageFileName);

            this.messages.add(config.getMsgSuccess());

            stream.close();

        } catch (IOException e) {
            this.error = true;
            this.messages.add(config.getMsgFail());
            throw new FileTransformException();
        } catch (InvalidImageDataException e) {
            this.error = true;
            this.messages.add(config.getMsgFail());
            throw new FileTransformException();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {

                    this.error = true;
                    this.messages.add(config.getMsgFail());
                    throw new FileTransformException();
                }
            }
        }

    }


    private String save(BufferedImage image) {

        String generatedFileName;

        try {

            File file = File.createTempFile("white-rabbit-", "." + config.getOutputFormat(), new File(config.getWorkDir()));
            ImageIO.write(image, config.getOutputFormat(), file);
            generatedFileName = file.getName();
            return generatedFileName;

        } catch (IOException e) {
            this.error = true;
            this.messages.add(config.getMsgFail());
            throw new FileTransformException();
        }

    }


    @Override
    public double getFileSize() {

        return this.fileSize / 1048576;
    }

    @Override
    public Boolean getError() {
        return this.error;
    }

    @Override
    public List getMessages() {
        return this.messages;
    }

}
