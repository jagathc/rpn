package rpn;

import org.junit.jupiter.api.Test;
import rpn.util.StringTokenizer;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTokenizerTest {

    @Test
    void shouldTokenizeString() {
        var tokenizer = new StringTokenizer(" a 10 + f 1.325 / aaa,bbb sqrt   ");

        var expected = List.of(
                    new StringTokenizer.Token("a", 1),
                    new StringTokenizer.Token("10", 3),
                    new StringTokenizer.Token("+", 6),
                    new StringTokenizer.Token("f", 8),
                    new StringTokenizer.Token("1.325", 10),
                    new StringTokenizer.Token("/", 16),
                    new StringTokenizer.Token("aaa,bbb", 18),
                    new StringTokenizer.Token("sqrt", 26)
                );

        var actual = tokenizer.stream().collect(Collectors.toUnmodifiableList());
        
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            var expectedVal = expected.get(i);
            var actualVal = actual.get(i);
            assertEquals(expectedVal.getValue(), actualVal.getValue());
            assertEquals(expectedVal.getStartPosition(), actualVal.getStartPosition());
        }
    }

    @Test
    void shouldNotFailWhenProcessingAnEmptyString() {
        var tokenizer = new StringTokenizer("");
        assertEquals(tokenizer.stream().count(), 0);
    }

    @Test
    void shouldNotFailWhenProcessingAnNullString() {
        var tokenizer = new StringTokenizer(null);
        assertEquals(tokenizer.stream().count(), 0);
    }

}