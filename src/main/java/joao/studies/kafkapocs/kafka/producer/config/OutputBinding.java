package joao.studies.kafkapocs.kafka.producer.config;

public enum OutputBinding {

    KAFKA_NEW_EVENT("kafka-new-event");

    private final String nameEvent;

    OutputBinding(final String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }
}
