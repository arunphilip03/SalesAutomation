package com.sfa.view.backing;


import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;


public class OppoAttachmentBean {
    private RichInputFile files;
    private String fileName;
    private String contentType;
    private BlobDomain blob;

    private UploadedFile file;

    public OppoAttachmentBean() {
    }

    public void onFileUploadVCL(ValueChangeEvent valueChangeEvent) {
        //System.out.println("valuechange");
        // Add event code here...
        file = (UploadedFile) valueChangeEvent.getNewValue();
        // Get the file name
        fileName = file.getFilename();
        // get the mime type
        contentType = file.getContentType();
        // get blob
        blob = getBlob(file);
    }

    public BlobDomain getBlob(UploadedFile file) {
        //System.out.println("getblob");
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();

            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    public void onFileUpload(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("onFileUpld");
        if (fileName != null) {
            DCBindingContainer bc = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding operationbinding = bc.getOperationBinding("uploadFiletoDB");
            if (operationbinding != null) {
                operationbinding.getParamsMap().put("fileName", fileName);
                operationbinding.getParamsMap().put("contentType", contentType);
                operationbinding.getParamsMap().put("blob", blob);
                operationbinding.execute();
            }
            //System.out.println("File uploaded successfully");
            if (files != null) {
                files.resetValue();
                files.setValid(true);
            }
        }
    }


    public void downloadFile(FacesContext facesContext, OutputStream outputStream) {
        // Add event code here...
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding iteratorbinding = bindings.findIteratorBinding("OpportunityAttachmentsView2Iterator");
        BlobDomain blob = (BlobDomain) iteratorbinding.getCurrentRow().getAttribute("Document");
        try {
            IOUtils.copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFiles(RichInputFile files) {
        this.files = files;
    }

    public RichInputFile getFiles() {
        return files;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }


    public void setBlob(BlobDomain blob) {
        this.blob = blob;
    }

    public BlobDomain getBlob() {
        return blob;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }
}

