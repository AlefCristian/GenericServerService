package module.garcon;

public enum ActionGarcon {
	CLOSECOMANDA(1), GETCARDAPIO(2), GETCOMANDA(3), GETPEDIDOS(4), SETPEDIDOS(5);
	
	private final int action;
	
	ActionGarcon(int action) {
		this.action = action;
	}
	
	public int getAction() {
		return this.action;
	}
	
	
}
