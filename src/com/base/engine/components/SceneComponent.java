<<<<<<< HEAD:src/com/base/engine/components/SceneComponent.java
package com.base.engine.components;

import com.base.engine.core.GameObject;
import com.base.engine.math.Transform;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.sceneManagement.Scene;
import com.base.engine.rendering.shaders.Shader;

public abstract class SceneComponent {

	private GameObject parent;
	private String Name;

	public Transform getTransform() {
		return parent.getTransform();
	}

	public Scene getParentScene() {
		return parent.getParentScene();
	}

	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}

	public void init() {
	}

	public void update(float delta) {
	}

	public void input(float delta) {
	}

	public void render(Shader shader, RenderingEngine engine) {
	}

	public void addToScene() {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
=======
package com.base.engine.components;

import com.base.engine.core.GameObject;
import com.base.engine.math.Transform;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.sceneManagement.Scene;
import com.base.engine.rendering.shaders.Shader;

public abstract class SceneComponent {

	private GameObject parent;
	private String Name;

	public Transform getTransform() {
		return parent.getTransform();
	}

	public Scene getParentScene() {
		return parent.getParentScene();
	}

	public GameObject getParent() {
		return parent;
	}

	public void setParent(GameObject parent) {
		this.parent = parent;
	}

	public void init() {
	}

	public void update(float delta) {
	}

	public void input(float delta) {
	}

	public void render(Shader shader, RenderingEngine engine) {
	}

	public void addToScene() {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
>>>>>>> s:src/com/base/engine/components/SceneComponent.java
