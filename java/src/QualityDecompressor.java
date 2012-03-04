import Huffman.BitInputStream;
import Huffman.CodeTree;
import Huffman.HuffmanDecoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ron
 * Date: 12/14/11
 * Time: 1:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class QualityDecompressor implements Decompressor {
    private ContextDictionary dictionary;
    private BitInputStream  bitInputStream;

    public void setInput(InputStream input) {
        bitInputStream = new BitInputStream(input);
    }

    public void fillNext(ReadData data) {
        for(int i = 0; i < data.getQuality().length(); i++) {
            String context = ContextHasher.hashContext(i, data.getSequence(), data.getQuality());
            CodeTree tree =   dictionary.getHuffmanTree(context);
            
            HuffmanDecoder huffmanDec = new HuffmanDecoder(bitInputStream);
            huffmanDec.codeTree = tree;

            try {
            data.appendCharToQuality((char)huffmanDec.read());
            } catch (IOException e) {
                System.out.println("cannot append any more to quality");

            }

        }
    }

    public void closeInput() throws IOException {
        bitInputStream.close();
    }
}
