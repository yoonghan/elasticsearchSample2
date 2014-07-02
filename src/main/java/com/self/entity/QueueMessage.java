package com.self.entity;


import java.util.Arrays;
import java.util.Date;

public class QueueMessage {
	private Long    id;
	private String  uuid;
	
	private Long    messageDefId;
	
	private Long    serviceId;
	
	private Integer operatorId;
	private Long    queueId;
	private Integer leafId;
	
	private String  userIdentifier;
	private Long    clusterNodeId;
	private Integer retriesCount      = 0;	
	private Date    deliveryDate;
	private Date    creationDate      = new Date();
	private Date    modificationDate  = creationDate;
	private Date    expireDate;
	
	private Long    targetId;	
	private Integer priority;	
	private Long    serverRuntimeId  = System.currentTimeMillis();
	private Integer fetchStatusId	 = 2;
	private Integer statusReasonId   ;
	private Integer statusId		 ;
	private String  header;
	private String  body;
	private byte[]  binaryContent;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public Long getMessageDefId() {
		return messageDefId;
	}


	public void setMessageDefId(Long messageDefId) {
		this.messageDefId = messageDefId;
	}


	public Long getServiceId() {
		return serviceId;
	}


	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}


	public Integer getOperatorId() {
		return operatorId;
	}


	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}


	public Long getQueueId() {
		return queueId;
	}


	public void setQueueId(Long queueId) {
		this.queueId = queueId;
	}


	public Integer getLeafId() {
		return leafId;
	}


	public void setLeafId(Integer leafId) {
		this.leafId = leafId;
	}


	public String getUserIdentifier() {
		return userIdentifier;
	}


	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}


	public Long getClusterNodeId() {
		return clusterNodeId;
	}


	public void setClusterNodeId(Long clusterNodeId) {
		this.clusterNodeId = clusterNodeId;
	}


	public Integer getRetriesCount() {
		return retriesCount;
	}


	public void setRetriesCount(Integer retriesCount) {
		this.retriesCount = retriesCount;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getModificationDate() {
		return modificationDate;
	}


	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}


	public Date getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}


	public Long getTargetId() {
		return targetId;
	}


	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}


	public Long getServerRuntimeId() {
		return serverRuntimeId;
	}


	public void setServerRuntimeId(Long serverRuntimeId) {
		this.serverRuntimeId = serverRuntimeId;
	}


	public Integer getFetchStatusId() {
		return fetchStatusId;
	}


	public void setFetchStatusId(Integer fetchStatusId) {
		this.fetchStatusId = fetchStatusId;
	}


	public Integer getStatusReasonId() {
		return statusReasonId;
	}


	public void setStatusReasonId(Integer statusReasonId) {
		this.statusReasonId = statusReasonId;
	}


	public Integer getStatusId() {
		return statusId;
	}


	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}


	public String getHeader() {
		return header;
	}


	public void setHeader(String header) {
		this.header = header;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public byte[] getBinaryContent() {
		return binaryContent;
	}


	public void setBinaryContent(byte[] binaryContent) {
		this.binaryContent = binaryContent;
	}

	@Override
	public String toString() {
		return "QueueMessage [id=" + id + ", uuid=" + uuid + ", messageDefId="
				+ messageDefId + ", serviceId=" + serviceId + ", operatorId="
				+ operatorId + ", queueId=" + queueId + ", leafId=" + leafId
				+ ", userIdentifier=" + userIdentifier + ", clusterNodeId=" + clusterNodeId
				+ ", retriesCount=" + retriesCount + ", deliveryDate="
				+ deliveryDate + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + ", expireDate="
				+ expireDate + ", targetId=" + targetId + ", priority="
				+ priority + ", serverRuntimeId=" + serverRuntimeId
				+ ", fetchStatusId=" + fetchStatusId + ", statusReasonId="
				+ statusReasonId + ", statusId=" + statusId + ", header="
				+ header + ", body=" + body + ", binaryContent="
				+ Arrays.toString(binaryContent) + "]";
	}
	
	
	
}

