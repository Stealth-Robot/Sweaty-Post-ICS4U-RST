/*
 * IScene.java
 * Instantiates scenes
 * Connor Adams || Matthew Edwards || Grayden Hibbert || Marcus Kubilius
 * June 2018
 */
package gui.scenes;

public interface IScene {
	//forces these methods to be implemented in scenes
	public void createEnvironment();
	public void createColliders();
	public void createBattleColliders();
}
