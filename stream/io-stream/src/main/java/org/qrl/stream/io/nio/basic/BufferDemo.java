package org.qrl.stream.io.nio.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.nio.IntBuffer;

/**
 * @author qr
 * @date 2021/11/30 11:03
 */
@SuppressWarnings("all")
@Slf4j
public class BufferDemo {

    private static IntBuffer INT_BUFFER = null;

    @Test
    public void intBufferDemo() {
        INT_BUFFER = IntBuffer.allocate(20);
        log.debug("-------------------- after allocate --------------------");
        INT_BUFFER.position();
    }
}
