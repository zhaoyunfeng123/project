package bean;

public class CaiBean {
	private int caiId;
	private String caiName;
	private String caiImageUrl;
	private String caiClass;
	private String caiRaw;
	private String caiOperandi;

	public String getCaiClass() {
		return caiClass;
	}

	public void setCaiClass(String caiClass) {
		this.caiClass = caiClass;
	}

	public String getCaiRaw() {
		return caiRaw;
	}

	public void setCaiRaw(String caiRaw) {
		this.caiRaw = caiRaw;
	}

	public String getCaiOperandi() {
		return caiOperandi;
	}

	public void setCaiOperandi(String caiOperandi) {
		this.caiOperandi = caiOperandi;
	}

	public CaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaiBean(int caiId, String caiName, 
			String caiClass,String caiImageUrl,String caiRaw, String caiOperandi) {
		super();
		this.caiId = caiId;
		this.caiName = caiName;
		
		this.caiClass=caiClass;
		this.caiImageUrl = caiImageUrl;
		
		this.caiRaw=caiRaw;
		this.caiOperandi=caiOperandi;
	}

	public int getCaiId() {
		return caiId;
	}

	public void setCaiId(int caiId) {
		this.caiId = caiId;
	}

	public String getCaiName() {
		return caiName;
	}

	public void setCaiName(String caiName) {
		this.caiName = caiName;
	}

	public String getCaiImageUrl() {
		return caiImageUrl;
	}

	public void setCaiImageUrl(String caiImageUrl) {
		this.caiImageUrl = caiImageUrl;
	}

}
