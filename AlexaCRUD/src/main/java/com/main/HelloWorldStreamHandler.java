package com.main;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.handlers.CancelandStopIntentHandler;
import com.handlers.HelloWorldIntentHandler;
import com.handlers.HelpIntentHandler;
import com.handlers.LaunchRequestHandler;
import com.handlers.SessionEndedRequestHandler;

public class HelloWorldStreamHandler extends SkillStreamHandler {
 
 private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler())
                .withSkillId("amzn1.ask.skill.ae811410-fdfa-4df4-8a3d-ec3b74137bf7")
                .build();
    }
public HelloWorldStreamHandler() {
        super(getSkill());
    }
}