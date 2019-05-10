/*
 * Copyright (c) 2019
 *  This file is part of the White Rabbit application.
 *
 *  (c) Vladimir Ganturin <gun2rin@gmail.com>
 *
 *  For the full copyright and license information, please view the LICENSE
 *  file that was distributed with this source code.
 */

package white.rabbit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

/**
 * The type Yaml config.
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="white-rabbit")
public class YAMLConfig {



    private int resultWidth;
    private int resultHeight;
    private int thumbWidth;
    private int thumbHeight;
    private String msgSuccess;
    private String msgFail;
    private String msgFailColor;
    private String msgFailType;
    private String workDir;
    private String outputFormat;
    private String downloadDir;
    private String downloadLink;
    private String redirectUrl;



    private List<String> mimeTypes;


    /**
     * Gets redirect url.
     *
     * @return the redirect url
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Sets redirect url.
     *
     * @param redirectUrl the redirect url
     */
    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    /**
     * Gets thumb width.
     *
     * @return the thumb width
     */
    public int getThumbWidth() {
        return thumbWidth;
    }

    /**
     * Sets thumb width.
     *
     * @param thumbWidth the thumb width
     */
    public void setThumbWidth(int thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    /**
     * Gets thumb height.
     *
     * @return the thumb height
     */
    public int getThumbHeight() {
        return thumbHeight;
    }

    /**
     * Sets thumb height.
     *
     * @param thumbHeight the thumb height
     */
    public void setThumbHeight(int thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    /**
     * Gets result width.
     *
     * @return the result width
     */
    public int getResultWidth() {
        return resultWidth;
    }

    /**
     * Sets result width.
     *
     * @param resultWidth the result width
     */
    public void setResultWidth(int resultWidth) {
        this.resultWidth = resultWidth;
    }

    /**
     * Gets result height.
     *
     * @return the result height
     */
    public int getResultHeight() {
        return resultHeight;
    }

    /**
     * Sets result height.
     *
     * @param resultHeight the result height
     */
    public void setResultHeight(int resultHeight) {
        this.resultHeight = resultHeight;
    }

    /**
     * Gets msg fail type.
     *
     * @return the msg fail type
     */
    public String getMsgFailType() {
        return msgFailType;
    }

    /**
     * Sets msg fail type.
     *
     * @param msgFailType the msg fail type
     */
    public void setMsgFailType(String msgFailType) {
        this.msgFailType = msgFailType;
    }

    /**
     * Gets msg success.
     *
     * @return the msg success
     */
    public String getMsgSuccess() {
        return msgSuccess;
    }

    /**
     * Sets msg success.
     *
     * @param msgSuccess the msg success
     */
    public void setMsgSuccess(String msgSuccess) {
        this.msgSuccess = msgSuccess;
    }

    /**
     * Gets msg fail.
     *
     * @return the msg fail
     */
    public String getMsgFail() {
        return msgFail;
    }

    /**
     * Sets msg fail.
     *
     * @param msgFail the msg fail
     */
    public void setMsgFail(String msgFail) {
        this.msgFail = msgFail;
    }

    /**
     * Gets msg fail color.
     *
     * @return the msg fail color
     */
    public String getMsgFailColor() {
        return msgFailColor;
    }

    /**
     * Sets msg fail color.
     *
     * @param msgFailColor the msg fail color
     */
    public void setMsgFailColor(String msgFailColor) {
        this.msgFailColor = msgFailColor;
    }

    /**
     * Gets work dir.
     *
     * @return the work dir
     */
    public String getWorkDir() {
        return workDir;
    }

    /**
     * Sets work dir.
     *
     * @param workDir the work dir
     */
    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    /**
     * Gets output format.
     *
     * @return the output format
     */
    public String getOutputFormat() {
        return outputFormat;
    }

    /**
     * Sets output format.
     *
     * @param outputFormat the output format
     */
    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    /**
     * Gets download dir.
     *
     * @return the download dir
     */
    public String getDownloadDir() {
        return downloadDir;
    }

    /**
     * Sets download dir.
     *
     * @param downloadDir the download dir
     */
    public void setDownloadDir(String downloadDir) {
        this.downloadDir = downloadDir;
    }

    /**
     * Gets download link.
     *
     * @return the download link
     */
    public String getDownloadLink() {
        return downloadLink;
    }

    /**
     * Sets download link.
     *
     * @param downloadLink the download link
     */
    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    /**
     * Gets mime types.
     *
     * @return the mime types
     */
    public List<String> getMimeTypes() {
        return mimeTypes;
    }

    /**
     * Sets mime types.
     *
     * @param mimeTypes the mime types
     */
    public void setMimeTypes(List<String> mimeTypes) {
        this.mimeTypes = mimeTypes;
    }




}
