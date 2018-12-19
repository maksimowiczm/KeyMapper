package io.github.sds100.keymapper.Views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import io.github.sds100.keymapper.R
import io.github.sds100.keymapper.Utils.AttrUtils.getCustomStringAttrValue
import kotlinx.android.synthetic.main.layout_service_status.view.*

/**
 * Created by sds100 on 15/11/2018.
 */
class ServiceStatusLayout(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
) : FrameLayout(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null, 0)

    private var mEnabledText: String? = null
    private var mDisabledText: String? = null

    init {
        View.inflate(context, R.layout.layout_service_status, this)

        if (attrs != null) {
            mEnabledText = getCustomStringAttrValue(
                    context,
                    attrs,
                    R.styleable.ServiceStatusLayout,
                    R.styleable.ServiceStatusLayout_enabledText
            )!!

            mDisabledText = getCustomStringAttrValue(
                    context,
                    attrs,
                    R.styleable.ServiceStatusLayout,
                    R.styleable.ServiceStatusLayout_disabledText
            )!!
        }

        //set to disabled state by default
        changeToServiceDisabledState()
    }

    fun changeToServiceEnabledState() {
        textViewStatus.text = mEnabledText
        textViewStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.check_circle_green, 0, 0, 0)

        buttonFix.visibility = View.GONE
    }

    fun changeToServiceDisabledState() {
        textViewStatus.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.close_circle_red, 0, 0, 0)
        textViewStatus.text = mDisabledText

        buttonFix.visibility = View.VISIBLE
    }

    fun setOnFixClickListener(onClickListener: OnClickListener) {
        buttonFix.setOnClickListener(onClickListener)
    }
}