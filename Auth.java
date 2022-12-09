public class Auth {
    public String login(String username, String password) {
        User admin = new User(
                "admin", "admin123");
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            return "Login Berhasil";
        } else {
            return "Login Gagal Cek Username Or Password";
        }
    }
}
