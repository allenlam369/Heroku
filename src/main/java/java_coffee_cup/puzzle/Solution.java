package java_coffee_cup.puzzle;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Solution {
	private @Id @GeneratedValue Long id;
	private String ans;

	Solution() {
	}

	public Solution(Long id, String ans) {
		this.id = id;
		this.ans = ans;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ans, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solution other = (Solution) obj;
		return Objects.equals(ans, other.ans) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", ans=" + ans + "]";
	}

}
