/*
 * Copyright (c) 2019
 *  This file is part of the White Rabbit application.
 *
 *  (c) Vladimir Ganturin <gun2rin@gmail.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package white.rabbit.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

/**
 * The type Options.
 */
public class Options {

    @NotNull
    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
    private String background;

    @NotNull
    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
    private String foreground;

    @Null
    private String thumbFileName;


    @Null
    private String imageFileName;


    /**
     * Instantiates a new Options.
     *
     * @param background the background
     * @param foreground the foreground
     */
    public Options(String background, String foreground) {

        this.background = background;
        this.foreground = foreground;
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets background.
     *
     * @param background the background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Gets foreground.
     *
     * @return the foreground
     */
    public String getForeground() {
        return foreground;
    }

    /**
     * Sets foreground.
     *
     * @param foreground the foreground
     */
    public void setForeground(String foreground) {
        this.foreground = foreground;
    }

    /**
     * Gets thumb file name.
     *
     * @return the thumb file name
     */
    public String getThumbFileName() {
        return thumbFileName;
    }

    /**
     * Sets thumb file name.
     *
     * @param thumbFileName the thumb file name
     */
    public void setThumbFileName(String thumbFileName) {
        this.thumbFileName = thumbFileName;
    }

    /**
     * Gets image file name.
     *
     * @return the image file name
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * Sets image file name.
     *
     * @param imageFileName the image file name
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
