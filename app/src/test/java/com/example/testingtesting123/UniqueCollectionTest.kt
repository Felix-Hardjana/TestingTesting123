package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {

        var origSize = collection.size()
        collection.addItem(Item("item1"))
        var newSize = collection.size()
        collection.addItem(Item("item2"))

        assert(newSize == origSize + 1 && collection.get(newSize - 1) == Item("Item")) {"Add item failed"}
        assert(origSize == 0 && newSize == 1){
            "Didn't add item"
        }
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {

        val collectionSize = collection.size()

        collection.addItem(Item("item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        assert(collection.get(0) == Item("item 1"))

        assert(collection.size() == 2) {
            "Don't have duplicate"
        }


    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}