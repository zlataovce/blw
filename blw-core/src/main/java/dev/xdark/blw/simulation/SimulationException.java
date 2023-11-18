package dev.xdark.blw.simulation;

public class SimulationException extends Exception{
	public SimulationException(String message) {
		super(message);
	}

	public SimulationException(String message, Throwable cause) {
		super(message, cause);
	}

	public SimulationException(Throwable cause) {
		super(cause);
	}

	public SimulationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
