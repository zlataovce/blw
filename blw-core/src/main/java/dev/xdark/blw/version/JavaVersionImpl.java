package dev.xdark.blw.version;

record JavaVersionImpl(int majorVersion, int minorVersion) implements JavaVersion {
	private static final int PREVIEW_FEATURES = 0xFFFF;

	@Override
	public int pack() {
		return majorVersion | minorVersion << 16;
	}

	@Override
	public boolean arePreviewFeaturesEnabled() {
		return minorVersion == PREVIEW_FEATURES;
	}

	@Override
	public JavaVersion withPreviewFeatures() {
		if (arePreviewFeaturesEnabled()) return this;
		return new JavaVersionImpl(majorVersion, PREVIEW_FEATURES);
	}

	@Override
	public JavaVersion dropPreviewFeatures() {
		if (arePreviewFeaturesEnabled()) return new JavaVersionImpl(majorVersion, 0);
		return this;
	}

	@Override
	public int jdkVersion() {
		return majorVersion - CLASS_VERSION_OFFSET;
	}

}
