package kodlamaio.hmrs.model.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_positions")
public class JobPosition {

    @Id
    @GeneratedValue
    private int id;

    @Column(name="job_name", nullable = false)
    private String jobName;
}
