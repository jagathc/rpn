package rpn.util;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StringTokenizer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\S+");
    private String str;


    public StringTokenizer(String str) {
        this.str = str;
    }

    public Stream<Token> stream() {

        var iterator = new Iterator<Token>() {
            private Matcher matcher = TOKEN_PATTERN.matcher(str != null ? str.trim() : "");

            @Override
            public boolean hasNext() {
                return matcher.find();
            }

            @Override
            public Token next() {
                return new Token( matcher.group(), matcher.start() + 1);
            }
        };

        return StreamSupport.stream(
                Spliterators.spliterator(iterator, 0, Spliterator.NONNULL),
                false
        );
    }

    public static class Token {
        private final String value;
        private final int startPosition;

        public Token(String value, int startPosition) {
            this.value = value;
            this.startPosition = startPosition;
        }

        public String getValue() {
            return value;
        }

        public int getStartPosition() {
            return startPosition;
        }
    }
}
