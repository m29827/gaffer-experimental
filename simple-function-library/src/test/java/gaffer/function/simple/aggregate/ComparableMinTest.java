package gaffer.function.simple.aggregate;

import gaffer.exception.SerialisationException;
import gaffer.function.AggregateFunctionTest;
import gaffer.jsonserialisation.JSONSerialiser;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComparableMinTest extends AggregateFunctionTest {
    @Test
    public void shouldReturnMinimumValue() {
        // Given
        final ComparableMin aggregator = getInstance();
        aggregator.init();

        // When
        aggregator._aggregate(3);
        aggregator._aggregate(1);
        aggregator._aggregate(2);

        // Then
        assertEquals(1, aggregator.state()[0]);
    }

    @Test
    public void shouldCloneAggregator() {
        // Given
        final ComparableMin aggregator = getInstance();
        aggregator._aggregate(1);

        // When
        final ComparableMin clone = aggregator.statelessClone();

        // Then
        assertNotSame(aggregator, clone);
        assertNull(clone.state()[0]);
    }


    @Test
    public void shouldJsonSerialiseAndDeserialise() throws SerialisationException {
        // Given
        final ComparableMin aggregator = getInstance();

        // When 1
        final String json = new String(new JSONSerialiser().serialise(aggregator, true));

        // Then 1
        assertEquals(String.format("{%n" +
                "  \"class\" : \"gaffer.function.simple.aggregate.ComparableMin\"%n" +
                "}"), json);

        // When 2
        final ComparableMin deserialisedAggregator = new JSONSerialiser().deserialise(json.getBytes(), getFunctionClass());

        // Then 2
        assertNotNull(deserialisedAggregator);
    }

    @Override
    protected ComparableMin getInstance() {
        return new ComparableMin();
    }

    @Override
    protected Class<ComparableMin> getFunctionClass() {
        return ComparableMin.class;
    }
}
