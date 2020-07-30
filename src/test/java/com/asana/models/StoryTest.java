package com.asana.models;

import com.asana.ModelTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StoryTest extends ModelTest {

    @Test
    public void json() {

        ResultBody<Story> r = this.parse(Story.class, "example-api-response/canonical/get_story_20200730.json");

        assertNotNull(r.data);

        //example uses same id for all related entities, kinda lame
        assertEquals("12345", r.data.duplicateOf.gid);
        assertEquals("12345", r.data.duplicatedFrom.gid);
        assertEquals("12345", r.data.follower.gid);

        //not in example
        //assertEquals("", r.data.dependent.gid);
        assertEquals("12345", r.data.dependency.gid);

        assertEquals("12345", r.data.story.gid);


    }

}
