package mayton.dht;

import org.apache.commons.lang3.Validate;
import the8472.bencode.BDecoder;
import the8472.bencode.Tokenizer;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Optional;

public class DhtMapConverter {

    public Optional<Map<String, Object>> convert(DatagramPacket datagramPacket) {
        Validate.notNull(datagramPacket, "Illegal argument in DhtMapConverter::apply");
        BDecoder decoder = new BDecoder();
        try {
            Map<String, Object> res = decoder.decode(ByteBuffer.wrap(datagramPacket.getData()));
            return Optional.of(res);
        } catch (Tokenizer.BDecodingException ex) {
            return Optional.empty();
        }
    }
}
