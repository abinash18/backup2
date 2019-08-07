package com.base.engine.core;

import java.util.ArrayList;

import com.base.engine.components.GameComponent;
import com.base.engine.math.Transform;
import com.base.engine.rendering.RenderingEngine;
import com.base.engine.rendering.Shader;

public class GameObject {

	private ArrayList<GameObject> children;
	private ArrayList<GameComponent> components;
	private Transform transform;
	private CoreEngine coreEngine;

	public GameObject() {
		this.children = new ArrayList<GameObject>();
		this.components = new ArrayList<GameComponent>();
		this.transform = new Transform();
		this.coreEngine = null;
	}

	public GameObject addChild(GameObject child) {
		child.getTransform().setParent(transform);
		child.setCoreEngine(coreEngine);
		children.add(child);
		return this;
	}

	public GameObject addComponent(GameComponent gameComponent) {
		gameComponent.setParent(this);
		components.add(gameComponent);

		return this;
	}

	public ArrayList<GameObject> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<GameObject> children) {
		this.children = children;
	}

	public void addToEngine(CoreEngine engine) {
		for (GameComponent component : components) {
			component.addToEngine(engine);
		}

		for (GameObject child : children) {
			child.addToEngine(engine);
		}
	}

	public void init() {
		for (GameComponent component : components) {
			component.init();
		}
		for (GameObject child : children) {
			child.init();
		}
	}

	public void input(float delta) {

		transform.update();

		for (GameComponent component : components) {
			component.input(delta);
		}

		for (GameObject child : children) {
			child.input(delta);
		}
	}

	public void update(float delta) {
		for (GameComponent component : components) {
			component.update(delta);
		}
		for (GameObject child : children) {
			child.update(delta);
		}
	}

	public void render(Shader shader, RenderingEngine engine) {
		for (GameComponent component : components) {
			component.render(shader, engine);
		}
		for (GameObject child : children) {
			child.render(shader, engine);
		}
	}

	public ArrayList<GameComponent> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<GameComponent> components) {
		this.components = components;
	}

	public Transform getTransform() {
		return transform;
	}

	public void setTransform(Transform transform) {
		this.transform = transform;
	}

	public CoreEngine getCoreEngine() {
		return coreEngine;
	}

	public void setCoreEngine(CoreEngine coreEngine) {
		if (this.coreEngine != coreEngine) {
			this.coreEngine = coreEngine;
			for (GameComponent component : components) {
				component.addToEngine(coreEngine);
			}
			for (GameObject child : children) {
				child.setCoreEngine(coreEngine);
			}
		}
	}

}
