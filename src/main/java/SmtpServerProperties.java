public enum SmtpServerProperties {

    MAILTRAP(
        true,
        true,
        "smtp.mailtrap.io",
        2525, "smtp.mailtrap.io",
        System.getenv().getOrDefault("LOGIN", "John Doe"),
        System.getenv().getOrDefault("PASSWORD", "Open Sesame")
    ),
    // TODO: add properties for SMTP Gmail server as an enum Object
    GMAIL(false, false, null, null, null, null, null)
    ;

    private final Boolean authorization;
    private final Boolean startTls;
    private final String host;
    private final Integer port;
    private final String sslTrust;
    private final String login;
    private final String password;

    SmtpServerProperties(Boolean authorization, Boolean startTls, String host, Integer port, String sslTrust, String login, String password) {
        this.authorization = authorization;
        this.startTls = startTls;
        this.host = host;
        this.port = port;
        this.sslTrust = sslTrust;
        this.login = login;
        this.password = password;
    }

    public Boolean getAuthorization() {
        return authorization;
    }

    public Boolean getStartTls() {
        return startTls;
    }

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getSslTrust() {
        return sslTrust;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
