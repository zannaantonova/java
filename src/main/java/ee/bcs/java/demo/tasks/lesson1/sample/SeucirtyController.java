package ee.bcs.java.demo.tasks.lesson1.sample;

public class SeucirtyController {
    /*
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("account/login")
    public String login(@RequestParam("password") String password){
        String dbPassword1 = "$2a$10$XR4o3dgVlC3VVOiBtZBgxeD8uRzT2fGCCZUAbRsQ2krrYUGcgFnZm";
        String dbPassword2 = "$2a$10$Em5GwOAkBmEtT3FbjxNT.ev.DMWVdDsfcbqNWezudJrZBxWb6FuWa";
        String dbPassword3 = "$2a$10$ieNmTF86F/hY4vIrXWtcw.Z6eP2L8Qc2qwIHzFXaO6YQxmumVz/iW";
        if (passwordEncoder.matches(password, dbPassword2)) {
            JwtBuilder builder = Jwts.builder()
                    .setIssuedAt(new Date())
                    .setIssuer("issuer")
                    .signWith(SignatureAlgorithm.HS256, "c2VjcmV0")
                    .claim("username", "siim");
            return builder.compact();
        } else {
            return "vale parool";
        }
    }

    @GetMapping("account/register")
    public String register(@RequestParam("username") String userName,
                           @RequestParam("password") String password){
        return passwordEncoder.encode(password);
    }*/
}
