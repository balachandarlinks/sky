package com.bala.bolt

import java.util.UUID

class Bolt {
    private val containerStore = mutableMapOf<String, BoltContainer>()

    /**
     * Creates a new container with the given id and returns the container.
     * If the container already exists, it will be returned.
     *
     * @param id The id of the container to create.
     * @return The container with the given id.
     */
    fun getContainer(id: String = UUID.randomUUID().toString()): BoltContainer {
        return containerStore.getOrPut(id) { BoltContainer() }
    }

    /**
     * Clears all the containers in the store.
     */
    fun clearContainers() {
        containerStore.clear()
    }
}