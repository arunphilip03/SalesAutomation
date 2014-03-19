package com.sfa.view.backing;


import com.sfa.model.service.AppModuleImpl;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCDataControl;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.domain.BlobDomain;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;


public class OppoAttachmentBean {
    private RichInputFile files = new RichInputFile();
    private String fileName;
    private String contentType;
    private BlobDomain blob;

    private UploadedFile file;
    private RichInputText it1;


    //    private List docType;
    //    private String selectedDocType;
    //    private RichSelectOneChoice docTypeSelectList;
    private RichLink uploadLink = new RichLink();
    private RichInputText plaintext = new RichInputText();
    private RichButton saveButton = new RichButton();


    //    public void setSelectedDocType(String selectedDocType) {
    //        this.selectedDocType = selectedDocType;
    //    }

    public String getSelectedDocType() {
        String s = null;
        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
        Map<String, Object> pfs = fctx.getPageFlowScope();
        if (pfs != null) {
            if (pfs.get("selectedDoc") == null)
                s = "";
            else
                s = (String) pfs.get("selectedDoc");
        }
        return s;

    }


    //    public void setDocType(List docType) {
    //        this.docType = docType;
    //    }
    //
    //    public List getDocType() {
    //        if (this.docType == null) {
    //            this.docType = selectedListReturn();
    //        }
    //        return this.docType;
    //    }

    //    public List<SelectItem> selectedListReturn() {
    //        List<SelectItem> selectItems = new ArrayList<SelectItem>();
    //
    //        selectItems.add(new SelectItem("1", "Document"));
    //        selectItems.add(new SelectItem("2", "Plain Text"));
    //
    //        return selectItems;
    //    }


    //    public void onDocTypeChange(ValueChangeEvent valueChangeEvent) {
    //        System.out.println("inside value change");
    //        if (valueChangeEvent.getOldValue().equals(valueChangeEvent.getNewValue()))
    //            return;
    //        String selectedDocType = (String) valueChangeEvent.getNewValue();
    //        System.out.println(selectedDocType);
    //        AdfFacesContext fctx = AdfFacesContext.getCurrentInstance();
    //        Map<String, Object> pfs = fctx.getPageFlowScope();
    //        if (pfs != null) {
    //            if (selectedDocType != null) {
    //                pfs.put("selectedDoc", selectedDocType);
    //                if ("1".equals(selectedDocType)) {
    //                    System.out.println("fiii");
    //
    //                        files.setVisible(true);
    //                        System.out.println(files.isVisible());
    //
    //                        uploadLink.setVisible(true);
    //
    //
    //                        plaintext.setVisible(false);
    //                       saveButton.setVisible(false);
    //
    //
    //                } else if ("2".equals(selectedDocType)) {
    //                    System.out.println("f22");
    //
    //                        files.setVisible(false);
    //                        uploadLink.setVisible(false);
    //
    //
    //                        plaintext.setVisible(true);
    //                        saveButton.setVisible(true);
    //
    //
    //                }
    //            } else {
    //                pfs.put("selectedDoc", "");
    //            }
    //        }
    //    }

    public void plainTextCommit(ActionEvent actionEvent) {
        // Add event code here...

        String plain = (String) plaintext.getValue();
        if (plain != null && plain != " ") {
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();

            AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("DocumentName");
            String fileN = (String) it1.getValue();

            System.out.println(fileN);
            if (fileN != null) {
                fileName = fileN;
            } else {
                String[] s1 = plain.split(" ");
                fileName = s1[0];
            }
            contentType = "plainText";
            OperationBinding operationbinding = bc.getOperationBinding("uploadFiletoDB");
            if (operationbinding != null) {
                operationbinding.getParamsMap().put("fileName", fileName);
                operationbinding.getParamsMap().put("contentType", contentType);
                operationbinding.getParamsMap().put("blob", blob);
                operationbinding.getParamsMap().put("plainText", plain);
                operationbinding.execute();
            }
            System.out.println("File uploaded successfully");
            if (files != null) {
                files.resetValue();
                files.setValid(true);
            }
        }

    }


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
            BindingContext bctx = BindingContext.getCurrent();
            BindingContainer bindings = bctx.getCurrentBindingsEntry();
            DCBindingContainer bc = (DCBindingContainer) bctx.getCurrentBindingsEntry();

            AttributeBinding attr = (AttributeBinding) bindings.getControlBinding("DocumentName");
            String fileN = (String) it1.getValue();
            System.out.println(fileN);
            if (fileN != null) {
                fileName = fileN;
            }

            OperationBinding operationbinding = bc.getOperationBinding("uploadFiletoDB");
            if (operationbinding != null) {
                operationbinding.getParamsMap().put("fileName", fileName);
                operationbinding.getParamsMap().put("contentType", contentType);
                operationbinding.getParamsMap().put("blob", blob);
                operationbinding.getParamsMap().put("plainText", "");
                operationbinding.execute();
            }
            System.out.println("File uploaded successfully");
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

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }


    //    public void setDocTypeSelectList(RichSelectOneChoice docTypeSelectList) {
    //        this.docTypeSelectList = docTypeSelectList;
    //    }
    //
    //    public RichSelectOneChoice getDocTypeSelectList() {
    //        return docTypeSelectList;
    //    }

    public void setUploadLink(RichLink uploadLink) {
        this.uploadLink = uploadLink;
    }

    public RichLink getUploadLink() {
        return uploadLink;
    }

    public void setPlaintext(RichInputText plaintext) {
        this.plaintext = plaintext;
    }

    public RichInputText getPlaintext() {
        return plaintext;
    }

    public void setSaveButton(RichButton saveButton) {
        this.saveButton = saveButton;
    }

    public RichButton getSaveButton() {
        return saveButton;
    }

    public void onLoadDisable(ActionEvent actionEvent) {
        // Add event code here...
        //        this.files.setVisible(false);
        //        this.uploadLink.setVisible(false);
        //        this.plaintext.setVisible(false);
        //        this.saveButton.setVisible(false);
        BindingContext context = BindingContext.getCurrent();
        BindingContainer bindings = context.getCurrentBindingsEntry();
        DCBindingContainer dc = (DCBindingContainer) bindings;
        OperationBinding op = dc.getOperationBinding("Create");
        op.execute();
    }

    public void docTypeReturn(ReturnPopupEvent returnPopupEvent) {
        // Add event code here...
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        // Get the sepecific list binding
        JUCtrlListBinding listBinding = (JUCtrlListBinding) bindings.get("DocumentType");
        // Get the value which is currently selected
        String selectedValue = (String) listBinding.getAttributeValue();
        System.out.println(selectedValue);
        if ("Document".equals(selectedValue)) {
            files.setVisible(true);
            System.out.println(files.isVisible());

            uploadLink.setVisible(true);


            plaintext.setVisible(false);
            saveButton.setVisible(false);
        } else if ("Plain Text".equals(selectedValue)) {
            files.setVisible(false);
            uploadLink.setVisible(false);


            plaintext.setVisible(true);
            saveButton.setVisible(true);
        }
    }
}

