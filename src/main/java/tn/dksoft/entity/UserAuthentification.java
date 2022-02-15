package tn.dksoft.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
public class UserAuthentification implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	private Long user_authen_id;
	
	private String username;
	private String password;
	private Boolean enabled;
	
	@ManyToMany (cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roles;


}
