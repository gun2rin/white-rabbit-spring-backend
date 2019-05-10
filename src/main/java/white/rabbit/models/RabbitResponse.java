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

import java.util.List;


/**
 * The type Message.
 */
public class RabbitResponse {

    private boolean success;
    private String fileSize;
    private String thumb;
    private String fullImage;
    private List<String> msg;


    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Gets file size.
     *
     * @return the file size
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * Sets file size.
     *
     * @param fileSize the file size
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Gets thumb.
     *
     * @return the thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * Sets thumb.
     *
     * @param thumb the thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * Gets full image.
     *
     * @return the full image
     */
    public String getFullImage() {
        return fullImage;
    }

    /**
     * Sets full image.
     *
     * @param fullImage the full image
     */
    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public List<String> getMsg() {
        return msg;
    }

    /**
     * Sets msg.
     *
     * @param msg the msg
     */
    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

}
