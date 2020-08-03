package com.asana.models;

import com.asana.ModelTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TaskTest extends ModelTest {
    @Test
    public void json() {

        ResultBody<Task> r = this.parse(Task.class, "example-api-response/canonical/get_task_20200730.json");

        assertNotNull(r.data);

        //example uses same id for all related entities, kinda lame
        // - not very useful ...
        assertEquals("12345", r.data.completedBy.gid);

        //not in example
        //assertEquals("", r.data.dependent.gid);
        assertEquals("12345", r.data.gid);

        assertEquals("12345", r.data.gid);
    }
}
