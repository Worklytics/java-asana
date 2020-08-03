package com.asana.models;

import com.google.gson.annotations.SerializedName;

import com.google.api.client.util.DateTime;

import java.util.Collection;

/**
 * models a Story;
 * many of the fields are conditional:
 * @see https://forum.asana.com/t/no-more-parsing-story-text-new-fields-on-stories/42924
 */
public class Story extends ResourceWithSubtype {
    @SerializedName("created_at")
    public DateTime createdAt;
    @SerializedName("created_by")
    public User createdBy;


    /**
     * whether user whose account is used to fetch Story has liked it
     */
    public boolean liked;

    //q: are hearts and likes equivalent?
    public Collection<Like> likes;

    @SerializedName("num_likes")
    public int numLikes;

    public String text;

    @SerializedName("html_text")
    public String htmlText;

    //usually, a Task
    public Resource target;

    @SerializedName("is_pinned")
    public boolean isPinned;
    @SerializedName("is_edited")
    public boolean isEdited;

    //client used to generate story
    public String source;

    // ?? doesn't seem applicable in current API, since Jan 2019?
    public String type;

    /**
     * conditional for 'added_to_tag'/'removed_from_tag' cases; will only have gid/name/resourceType populated.
     */
    public Tag tag;

    /**
     * conditional for 'added_to_project'/'removed_from_project' cases; will only have gid/name/resourceType populated.
     */
    public Project project;


    /**
     * conditional for 'collaborator_added'; haven't seen example of this
     */
    public User collaborator;

    /**
     * conditional for 'assigned'
     */
    public User assignee;

    /**
     * not documented, but in example response in API documentation in July 2020
     */
    public User follower;

    @SerializedName("duplicate_of")
    public Task duplicateOf;

    @SerializedName("duplicated_from")
    public Task duplicatedFrom;

    /**
     * conditional for 'comment_liked`/`completion_liked` cases
     */
    public Story story;

    /**
     * the task that this one depends on
     * conditional for `dependency_*` cases
     */
    public Task dependency;

    /**
     * the task that depends on this one
     * conditional for `dependent_*` cases
     */
    public Task dependent;

}
