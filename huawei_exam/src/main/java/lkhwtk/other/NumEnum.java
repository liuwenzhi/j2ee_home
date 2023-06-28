package lkhwtk.other;

/**
 * 定义一个枚举供参考下
 */
public enum NumEnum {
    ONE("one"),
    TWO("two"),
    THREE("three"),
    FOUR("four"),
    FIVE("five"),
    SIX("six"),
    SEVEN("seven"),
    EIGHT("eight"),
    NINE("nine"),
    TEN("ten");

    private String value;
    private NumEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
