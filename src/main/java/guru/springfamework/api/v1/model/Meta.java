package guru.springfamework.api.v1.model;

import lombok.Data;

@Data
public class Meta {
    private Integer count;
    private Integer limit;
    private Integer page;
    private String previous_url;
    private String next_url;
}
