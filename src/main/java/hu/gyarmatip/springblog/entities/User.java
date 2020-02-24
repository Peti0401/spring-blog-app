package hu.gyarmatip.springblog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("password='" + password + "'")
                .add("email='" + email + "'")
                .add("posts=" + posts.stream().map(Post::getTitle).collect(Collectors.joining(", ")))
                .toString();
    }
}
