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
import java.util.List;



/**
 * The interface File transform.
 *
 * @param <T> the type parameter
 * @param <E> the type parameter
 */
public interface FileTransform<T,E>  {


    /**
     * Transform.
     *
     * @param source  the source
     * @param options the options
     */
    void transform(T source, E options);

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    Boolean validate();



    /**
     * Gets error.
     *
     * @return the error
     */
    Boolean getError();


    /**
     * Gets messages.
     *
     * @return the messages
     */
    List getMessages();


    /**
     * Gets file size.
     *
     * @return the file size
     */
    double getFileSize();
}
