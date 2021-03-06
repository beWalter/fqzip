import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReadData {
    private StringBuilder header = null;
    private StringBuilder sequence = null;
    private StringBuilder quality = null;

    ReadData() throws IOException {
        quality = new StringBuilder();
    }
    
    ReadData(BufferedReader reader) throws IOException {
        String headerLine = reader.readLine();
        if (headerLine == null) {
            return;
        }

        header = new StringBuilder(headerLine);
        sequence = new StringBuilder (reader.readLine());
        reader.readLine();
        quality =  new StringBuilder (reader.readLine());
    }
    public void write(BufferedWriter writer) throws IOException {
        writer.write(header.toString());
        writer.newLine();
        writer.write(sequence.toString());
        writer.newLine();
        writer.write("+");
        writer.newLine();
        writer.write(quality.toString());
        writer.newLine();
    }
    public String getHeader() {
        return header != null ? header.toString() : null;
    }
    public String getSequence() {
        return sequence != null ? sequence.toString() : null;
    }
    public String getQuality() {
        return quality != null ? quality.toString() : null;
    }
    public void appendCharToHeader(char character) {
      header.append(character);
    }
    public void appendCharToSequencechar (char character){
        sequence.append(character);
    }
    public void appendCharToQuality(char character) {
        quality.append(character);
    }

    public void setHeader(String header) {
        this.header = header != null ? new StringBuilder(header) : null;
    }
    public void setSequence(String sequence) {
        this.sequence = sequence != null ? new StringBuilder(sequence) : null;
    }
    public void setQuality(String quality) {
        this.quality = quality != null ? new StringBuilder(quality) : null;
    }
}
