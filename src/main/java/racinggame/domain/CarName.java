package racinggame.domain;

public class CarName {
    private static final int LIMIT_LENGTH = 5;

    private String value;

    public String getValue() {
        return value;
    }

    /**
     * @throws IllegalArgumentException 자동차 이름이 5자 초과일 경우
     */
    public CarName(String name) {
        if (isLongNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. (입력된 자동차 이름: " + name + ")");
        }
        this.value = name;
    }

    private boolean isLongNameLength(String name) {
        return name.length() > LIMIT_LENGTH;
    }
}
