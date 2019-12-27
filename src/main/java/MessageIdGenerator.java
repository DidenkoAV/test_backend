import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.UUIDTimer;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import java.io.IOException;
import java.util.Random;



public class MessageIdGenerator {
    private static final TimeBasedGenerator UUID_GENERATOR;
    static {
        final Random random = new Random(System.currentTimeMillis());
        final UUIDTimer timer;
        try {
            timer = new UUIDTimer(random, null);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        final EthernetAddress addr = EthernetAddress.fromInterface();
        UUID_GENERATOR = new TimeBasedGenerator(addr, timer);
    }
    public static String generate() {
        return UUID_GENERATOR.generate().toString();
    }
}