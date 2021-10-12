package com.sketch01.api.attachfile;

import com.sketch01.api.attachfile.data.AttachFilePolicyListData;
import com.sketch01.api.attachfile.data.AttachFilePolicySaveData;
import com.sketch01.api.attachfile.service.AttachFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttachFileController {

    private final AttachFileService attachFileService;

    @RequestMapping("/api/attach-file/policy")
    public AttachFilePolicyListData selectList() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return attachFileService.selectList();
    }

    @PostMapping("/attach-file/policy")
    public AttachFilePolicySaveData savePolicy(@RequestBody AttachFilePolicySaveData attachFilePolicySaveData) {
        return attachFileService.savePolicy(attachFilePolicySaveData);
    }
}
