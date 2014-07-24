package gr.iti.mklab.simmo.annotations.lowleveldescriptors;


public class LocalDescriptors {


	/** * The item unique id */
	protected String id;


	/** Types of local low level descriptors */
	public enum DESCRIPTOR_TYPE{SIFT, SIFT_RGB, SIFT_OPPONENT, SURF, SURF_RGB, SURF_OPPONENT};

	
	/** Types of feature encodings */
	public enum FEATURE_ENCODING{BoW, Vlad};
	
	
	/** The type of descriptor */
	private DESCRIPTOR_TYPE descriptorType;

	
	/** The type of descriptor */
	private FEATURE_ENCODING featureEncodingType;
	
	
	/** The number of features itself */
	private int numberOfFeatures;
	

	/** The values of the descriptor */
	private String descriptorValue;

	
	/** The values of the descriptor */
	private String featureEncodingLibrary;
	
	
	public String getDescriptorValue() {
		return descriptorValue;
	}

	public void setDescriptorValue(String descriptorValue) {
		this.descriptorValue = descriptorValue;
	}

	public DESCRIPTOR_TYPE getDescriptorType() {
		return descriptorType;
	}

	public void setDescriptorType(DESCRIPTOR_TYPE descriptorType) {
		this.descriptorType = descriptorType;
	}

	public FEATURE_ENCODING getFeatureEncoding() {
		return featureEncodingType;
	}

	public void setFeatureEncoding(FEATURE_ENCODING featureEncodingType) {
		this.featureEncodingType = featureEncodingType;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public int getNumberOfFeatures() {
		return numberOfFeatures;
	}

	public void setNumberOfFeatures(int numberOfFeatures) {
		this.numberOfFeatures = numberOfFeatures;
	}
	
	public String getFeatureEncodingLibrary() {
		return featureEncodingLibrary;
	}
	
	public void setFeatureEncodingLibrary(String featureEncodingLibrary) {
		this.featureEncodingLibrary = featureEncodingLibrary;
	}
}
