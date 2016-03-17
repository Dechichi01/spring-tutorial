package com.dechichi.spring.web.DAO;

public class Offer {
	private int id;
	private User user;
	private String text;

	public Offer() {
		this.user = new User();
	}

	public Offer(User user, String text) {
		this.user = user;
		this.text = text;
	}



	public Offer(int id, User user, String text) {
		this.id = id;
		this.user = user;
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername(){
		return user.getUsername();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Offer)) return false;

		Offer offer = (Offer) o;

		if (!getUser().equals(offer.getUser())) return false;
		return getText() != null ? getText().equals(offer.getText()) : offer.getText() == null;

	}

	@Override
	public int hashCode() {
		int result = getUser().hashCode();
		result = 31 * result + (getText() != null ? getText().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Offer{" +
				"id=" + id +
				", user=" + user +
				", text='" + text + '\'' +
				'}';
	}
}