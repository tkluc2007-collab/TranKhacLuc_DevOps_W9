package banksystem;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FilePathTest {

    @Test
    void testPathSeparatorAcrossOS() {
        // [BÀI 4]: Dung File.separator de tu dong thich nghi Win (\) hoac Linux (/)
        String expectedPath = "target" + File.separator + "reports";
        File file = new File("target", "reports");

        System.out.println("Path dang chay tren OS: " + file.getPath());
        assertEquals(expectedPath, file.getPath());
    }
}