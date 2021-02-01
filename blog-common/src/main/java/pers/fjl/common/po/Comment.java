package pers.fjl.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import pers.fjl.common.utils.JsonLongSerializer;

/**
 * <p>
 *
 * </p>
 *
 * @author fangjiale
 * @since 2021-01-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = JsonLongSerializer.class )
    @TableId(value = "comment_id")
    private Long commentId;

    private Long uid;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @com.baomidou.mybatisplus.annotations.TableField("`create_time`")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private LocalDateTime createTime;

    private Long blogId;

    @JsonSerialize(using = JsonLongSerializer.class )
    private Long parentCommentId;

    @TableField(exist = false)
    private String nickname;

    @TableField(exist = false)
    private String avatar;

    @TableField(exist = false)
    private List<Comment> children;

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

}
