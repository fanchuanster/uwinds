package challenge;

public class FileScore implements Comparable<FileScore> {
	private String fileName;
	private int score;
	private boolean reverseCompare;
	
	public FileScore(String fileName, int score, boolean reverseCompare) {
		this.fileName = fileName;
		this.score = score;
		this.reverseCompare = reverseCompare;
	}
	
	public String getFile() {
		return fileName;
	}
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(FileScore fileScore) {
		return reverseCompare ? 0 - Integer.compare(this.getScore(), fileScore.getScore()) : Integer.compare(this.getScore(), fileScore.getScore());
	}
	
}