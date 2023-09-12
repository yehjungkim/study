package physical.education.yehjung.Member.dto;

public enum Authority {

    MEMBER("member"), ADMIN("admin");

    private final String authority;

    Authority(String authority){
        this.authority = authority;
    }

}
