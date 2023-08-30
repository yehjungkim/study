package pe.pecommunity.domain.member.domain;

public enum Authority {
    MEMBER("member"), ADMIN("admin"), DORMANT_ACCOUNT("dormant_account");

    private final String authNm;

    Authority(String value) {
        this.authNm = value;
    }
}
