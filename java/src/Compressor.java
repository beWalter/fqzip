import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: ron
 * Date: 12/14/11
 * Time: 12:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Compressor {
    void setOutput(OutputStream input);
    void compressNext(ReadData data);

}