package com.syntel;

import com.syntel.Scenes.HomeScene;
import com.syntel.Scenes.Scene;

public class SceneManager {

    private Scene scene;

    public SceneManager() {
        scene = new HomeScene();
    }

    public void main() {
        while (true) {
            while (!scene.requestTransition)
                scene.process();
            scene = scene.transitionNext();
        }
    }
}
