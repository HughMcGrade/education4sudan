class NotificationsController < ApplicationController

  def index
    @school = School.find(params[:school_id])
  end

  def show
    @notification = Notification.find(params[:id])
  end

  def new
  end

  def create
    @notification = Notification.create(notification_params)
    redirect_to school_path(@notification.school_id), :notice => "Notification created successfully!"
  end

  private

  def notification_params
    params.require(:notification).permit(:title, :content, :school_id)
  end

end
