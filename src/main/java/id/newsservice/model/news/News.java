package id.newsservice.model.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="n_id")
	private Long id;
	
	@Column(name="n_u_id")
	private Long userId;
	
	@Column(name="n_c_id")
	private Long categoryId;
	
	@Column(name="n_title")
	private String title;
	
	@Column(name="n_description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
